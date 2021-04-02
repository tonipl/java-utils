package tonipl.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Common implements Serializable {
    private static final long serialVersionUID = -8532427860320200108L;

    @NotEmpty(message = "Id may not be empty")
    private Long id;

    @NotEmpty(message = "Creation author id may not be empty")
    private String creationAuthor;

    private String modificationAuthor;

    @NotNull(message = "Creation date may not be null")
    private Date creationDate;

    private Date modificationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreationAuthor() {
        return creationAuthor;
    }

    public void setCreationAuthor(String creationAuthor) {
        this.creationAuthor = creationAuthor;
    }

    public String getModificationAuthor() {
        return modificationAuthor;
    }

    public void setModificationAuthor(String modificationAuthor) {
        this.modificationAuthor = modificationAuthor;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
