package $package;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ${package}.api.TemplateResourceApi;
import ${package}.model.Template;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class TemplateResource implements TemplateResourceApi {

  private final TemplateResourceClient client;

  private final TemplateRepository repository;

  public TemplateResource(TemplateResourceClient client, TemplateRepository repository) {
    this.client = client;
    this.repository = repository;
  }

  @Override
  public ResponseEntity<List<Template>> getTemplate() {
    client.getTemplate();
    return ResponseEntity.of(Optional.of(Collections.singletonList(new Template())));
  }

  @Override
  public ResponseEntity<Template> getTemplateById(Long id) {
    return ResponseEntity.of(
        repository
            .findById(id)
            .map(entity -> new Template().name(entity.getName())));
  }
}
