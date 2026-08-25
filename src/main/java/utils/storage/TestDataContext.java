package utils.storage;

import java.util.HashMap;
import java.util.Map;

public class TestDataContext {

    private final Map<String, Object> scenarioContext = new HashMap<>();

    public void setContext(IContextKey key, Object value) {
        scenarioContext.put(key.getName(), value);
    }


    public Object getContext(IContextKey key) {
        return scenarioContext.get(key.getName());
    }

    public String getContextAsString(IContextKey key) {
        return (String) scenarioContext.get(key.getName());
    }

}
