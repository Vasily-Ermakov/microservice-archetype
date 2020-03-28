package $package;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ${package}.api.TemplatesResourceApi;
import ${package}.model.Template;

import java.util.Optional;

@Controller
public class TemplatesResource implements TemplatesResourceApi {

  private final TemplatesResourceClient client;
  private final EntityRepository repository;

  public TemplatesResource(TemplatesResourceClient client, EntityRepository repository) {
    this.client = client;
    this.repository = repository;
  }

  @Override
  public ResponseEntity<Template> getTemplate() {
    client.getTemplate();
    return ResponseEntity.of(Optional.of(new Template()));
  }

  @Override
  public ResponseEntity<Template> getTemplateById(Long id) {
    return ResponseEntity.of(
            repository
                    .findById(id)
                    .map(entity -> new Template().name(entity.getName())));
  }
}
