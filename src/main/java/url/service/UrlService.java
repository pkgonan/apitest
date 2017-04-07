package url.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UrlService {
    private Map<String, Long> ids = new ConcurrentHashMap<>();
    private Map<Long, String> urls = new ConcurrentHashMap<>();
    private long key = 0;

    public synchronized long regist(String url){
        if(!isExist(url)) {
            key += 1;
            ids.put(url, key);
            urls.put(key, url);

            return key;
        }
        return ids.get(url);
    }

    public boolean isExist(String url){
        if(ids.containsKey(url))
            return true;
        return false;
    }
}