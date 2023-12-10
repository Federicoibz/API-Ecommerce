package personal.proyect.ArchUnit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import personal.proyect.Controller.BaseController;
import personal.proyect.Service.BaseService;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "personal.proyect",importOptions = ImportOption.DoNotIncludeTests.class)
class ArchUnitTest {

    @ArchTest
    public static final ArchRule layerRule =
            layeredArchitecture().consideringAllDependencies()
                    .layer("Controller").definedBy("personal.proyect.Controller")
                    .layer("Service").definedBy("personal.proyect.Service")
                    .layer("Persistence").definedBy("personal.proyect.Repository")

                    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                    .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

    @ArchTest
    public static final ArchRule controllerNameRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().resideInAPackage("personal.proyect.Controller");

    @ArchTest
    public static final ArchRule controllerBaseRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().implement(BaseController.class)
                    .orShould().haveSimpleName("BaseController");

    @ArchTest
    public static final ArchRule serviceNameRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().resideInAPackage("personal.proyect.Service");

    @ArchTest
    public static final ArchRule serviceBaseRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().implement(BaseService.class)
                    .orShould().haveSimpleName("BaseServiceImpl");

    @ArchTest
    public static final ArchRule repositoryNameRule =
            classes().that().haveSimpleNameEndingWith("Repository").should().resideInAPackage("personal.proyect.Repository");

    @ArchTest
    public static final ArchRule entitiesAnnotation =
            classes().that().resideInAPackage("personal.proyect.Entities").should().beAnnotatedWith(Entity.class)
                    .orShould().haveSimpleName("Base");
}
