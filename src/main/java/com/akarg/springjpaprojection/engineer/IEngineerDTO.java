package com.akarg.springjpaprojection.engineer;

/**
 * @author Akhilesh Garg
 * @since 16-11-2022
 */
// Projection Interface, internally dynamic proxy class will be created at runtime
// and dynamic proxy class instance will be used for implementation under the hood
public interface IEngineerDTO {

    String getId();

    Integer getSalary();

}
