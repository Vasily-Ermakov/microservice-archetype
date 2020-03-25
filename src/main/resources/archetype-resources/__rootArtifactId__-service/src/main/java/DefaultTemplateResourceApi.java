package $package;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import ${package}.api.TemplateResourceApi;
import ${package}.model.Template;

import java.util.Optional;

@Controller
public class DefaultTemplateResourceApi implements TemplateResourceApi {

  @Override
  public ResponseEntity<Template> getTemplate() {
    return ResponseEntity.of(Optional.of(new Template()));
  }
}
