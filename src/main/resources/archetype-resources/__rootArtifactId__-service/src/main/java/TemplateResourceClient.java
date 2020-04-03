#set($dollar = '$')
package $package;

import org.springframework.cloud.openfeign.FeignClient;
import ${package}.api.TemplateResourceApi;

@FeignClient(name = "template", url = "${dollar}{feign.${rootArtifactId}-api.url}")
public interface TemplateResourceClient extends TemplateResourceApi {
}
