package com.jake.StudentManager.services;

    import com.jake.StudentManager.exceptions.StudentNotFoundException;
    import com.jake.StudentManager.pojo.Module;
    import com.jake.StudentManager.pojo.Student;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import javax.management.Query;
    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

@Service
public class ModuleService {

    @Autowired
    StudentService studentService;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
    EntityManager em = emf.createEntityManager();

    public ModuleService(){}

    public void assignModule(Student student, Module module) throws StudentNotFoundException{
        if(!studentService.studentExists(student)){
           throw new StudentNotFoundException("Student not found");
        }else{

//            String jpql = "insert into STUDENT_MODULE_LIST (STUDENTID, COURSEWORK_WEIGHT, EXAM_WEIGHT, MODULEID, MODULE_TITLE) values ('1', '70', '30', '10', 'sqlTitle')";
//            Query query = (Query) em.createQuery(jpql);

        }
    }

    public void removeModule(Student student, Module module)throws StudentNotFoundException{
        if (!studentService.studentExists(student) || !moduleExists(student, module)) {
            throw new StudentNotFoundException("Student or module could not be found");
        } else {

        }
    }

    public void updateModule(Student student, Module oldModule, Module newModule){
        if (!studentService.studentExists(student) || !moduleExists(student, oldModule)) {
            throw new StudentNotFoundException("Student or module could not be found");
        } else {

        }
    }

    public boolean moduleExists(Student student, Module module){
        return student.getModuleList().contains(module);
    }

    public Module getModule(Student student, Integer moduleID) {
        return student.getModuleList().stream().filter(module -> module.getModuleID().equals(moduleID)).findFirst().get();
    }
}
