package interfaceFonctionnel;

public interface Operation<T> {
    T function(String data);
    void onSuccess(T res);
    void onError(Exception ex);
}
