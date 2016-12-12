package controller;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Bárbara
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(controller.CargosResource.class);
        resources.add(controller.ClientesResource.class);
        resources.add(controller.ContatosResource.class);
        resources.add(controller.EmailsResource.class);
        resources.add(controller.EmpresaResource.class);
        resources.add(controller.FornecedoresResource.class);
        resources.add(controller.FuncionariosResource.class);
        resources.add(controller.LoginResource.class);
        resources.add(controller.PessoasResource.class);
        resources.add(controller.ProdutosResource.class);
    }
    
}
