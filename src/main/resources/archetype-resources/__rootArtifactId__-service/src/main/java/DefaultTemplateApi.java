package $package;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import p.api.TemplateApi;
import p.model.Template;

import java.util.Optional;

@Controller
public class DefaultTemplateApi implements TemplateApi {

  @Override
  public ResponseEntity<Template> getTemplate() {
    return ResponseEntity.of(Optional.of(new Template()));
  }
}
