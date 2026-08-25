package utils.storage;

public enum ContextKey implements IContextKey {

    COMMUNITY_NAME;

    @Override
    public String getName() {
        return name();
    }
}
