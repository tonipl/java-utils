package tonipl.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import tonipl.utils.Constants;
import tonipl.utils.It;

public class Common implements Serializable {
    private static final long serialVersionUID = -8532427860320200108L;


    @NotEmpty(message = "Id may not be empty")
    private Long id;

    @NotEmpty(message = "Creation author id may not be empty")
    private String creationAuthor;

    private String modificationAuthor;

    @NotNull(message = "Creation date may not be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
    private Date creationDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
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



    @Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (It.isNull(o) || getClass() != o.getClass()) {
			return false;
		}

		Common that = (Common) o;
		return ((It.isNull(id) && It.isNull(that.getId())) || (It.isNotNull(id) && id.equals(that.getId()))) &&
				((It.isNull(creationAuthor) && It.isNull(that.getCreationAuthor())) || (It.isNotNull(creationAuthor) && creationAuthor.equals(that.getCreationAuthor()))) &&
				((It.isNull(creationDate) && It.isNull(that.getCreationDate())) || (It.isNotNull(creationDate) && creationDate.equals(that.getCreationDate()))) &&
				((It.isNull(modificationAuthor) && It.isNull(that.getModificationAuthor())) || (It.isNotNull(modificationAuthor) && modificationAuthor.equals(that.getModificationAuthor()))) &&
				((It.isNull(modificationDate) && It.isNull(that.getModificationDate())) || (It.isNotNull(modificationDate) && modificationDate.equals(that.getModificationDate())));
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, creationAuthor, creationDate, modificationAuthor, modificationDate);
	}
}
