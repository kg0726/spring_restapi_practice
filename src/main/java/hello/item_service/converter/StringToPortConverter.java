package hello.item_service.converter;

import hello.item_service.domain.IpPort;
import org.springframework.core.convert.converter.Converter;

public class StringToPortConverter implements Converter<String, IpPort> {

    @Override
    public IpPort convert(String source) {
        // "127.0.0.1:8000" 같은 문자열을 분리하는 로직
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip, port);
    }
}
