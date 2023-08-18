package Model;

import java.sql.Timestamp;

/**
 *
 * @author Lim En Xi
 */
public class Super<T> {

    private Timestamp _createdDate;
    private Timestamp _updatedDate;
    private String _createdBy;
    private String _updatedBy;
    private String _errText;

    public Timestamp getCreatedDate() {
        return _createdDate;
    }

    public Timestamp getUpdatedDate() {
        return _updatedDate;
    }

    public String getCreatedBy() {
        return _createdBy;
    }

    public String getUpdatedBy() {
        return _updatedBy;
    }

    public String getErrText() {
        return _errText;
    }

    public T setErrText(String errText) {
        _errText = errText;
        return (T) this;
    }

    public T setCreatedBy(String createdBy) {
        _createdBy = createdBy;
        return (T) this;
    }

    public T setCreatedDate(Timestamp createdDate) {
        _createdDate = createdDate;
        return (T) this;
    }

    public T setUpdatedDate(Timestamp updatedDate) {
        _updatedDate = updatedDate;
        return (T) this;
    }

    public T setUpdatedBy(String updatedBy) {
        _updatedBy = updatedBy;
        return (T) this;
    }

}
