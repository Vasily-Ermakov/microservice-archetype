package $package;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ${package}.api.TemplatesResourceApi;
import ${package}.model.Template;

import java.util.Optional;

@Controller
public class TemplatesResource implements TemplatesResourceApi {

  private final TemplatesResourceClient client;

  public TemplatesResource(TemplatesResourceClient client) {
    this.client = client;
  }

  @Override
  public ResponseEntity<Template> getTemplate() {
    client.getTemplate();
    return ResponseEntity.of(Optional.of(new Template()));
  }
}
