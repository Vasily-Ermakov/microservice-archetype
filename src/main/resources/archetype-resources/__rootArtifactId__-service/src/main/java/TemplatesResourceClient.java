#set($dollar = '$')
package $package;

import org.springframework.cloud.openfeign.FeignClient;
import ${package}.api.TemplatesResourceApi;

@FeignClient(name = "template", url = "${dollar}{feign.${rootArtifactId}-api.url}")
public interface TemplatesResourceClient extends TemplatesResourceApi {
}
