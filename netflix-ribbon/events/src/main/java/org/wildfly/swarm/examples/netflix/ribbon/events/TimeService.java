package org.wildfly.swarm.examples.netflix.ribbon.events;

import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;
import com.netflix.ribbon.proxy.annotation.TemplateName;
import io.netty.buffer.ByteBuf;

import java.sql.Time;

/**
 * @author Bob McWhirter
 */
@ResourceGroup( name="time" )
public interface TimeService {

    static TimeService INSTANCE = Ribbon.from(TimeService.class);

    @TemplateName("currentTime")
    @Http(
            method = Http.HttpMethod.GET,
            uri = "/"
    )
    RibbonRequest<ByteBuf> currentTime();
}