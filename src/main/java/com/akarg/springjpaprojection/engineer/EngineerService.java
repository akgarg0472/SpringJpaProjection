package com.akarg.springjpaprojection.engineer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Akhilesh Garg
 * @since 16-11-2022
 */
@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class EngineerService {

    private final EngineerRepo engineerRepo;

    private final Random random = new Random();

    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        final var count = random.nextInt(5, 10);
        final List<Engineer> engineers = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            final var id = UUID.randomUUID().toString();
            final var firstName = "Engineer";
            final var lastName = "#" + i;
            final var createdAt = System.currentTimeMillis();
            final var salary = random.nextInt(10000, 100000);
            final var type = getType();

            final var engineer = new Engineer(id, firstName, lastName, type, createdAt, salary);
            engineers.add(engineer);
        }

        this.engineerRepo.saveAll(engineers);
    }

    public List<Engineer> getAllEngineers() {
        return this.engineerRepo.findAll();
    }

    public List<Engineer> getAllEngineersByType(final EngineerType engineerType) {
        return this.engineerRepo.findAllByType(engineerType);
    }

    public List<IEngineerDTO> getEngineersHavingSalaryGreaterThan_InterfaceProjection(final Integer minimumSalary) {
        return this.engineerRepo.findAllBySalaryGreaterThan(minimumSalary);
    }

    public List<EngineerDTO> getEngineersHavingSalaryGreaterThan_ClassProjection(final int minimumSalary) {
        return this.engineerRepo.findAllBySalaryGreaterThan_Class(minimumSalary);
    }

    private EngineerType getType() {
        final int randomInteger = this.random.nextInt(10);

        if (randomInteger % 4 == 0) return EngineerType.SOFTWARE;
        else if (randomInteger % 3 == 0) return EngineerType.HARDWARE;
        else if (randomInteger % 2 == 0) return EngineerType.ELECTRICAL;
        else return EngineerType.MECHANICAL;
    }

}
