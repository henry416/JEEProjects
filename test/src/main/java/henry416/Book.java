package henry416;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b ORDER BY b.title DESC")
public class Book {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  @Size(min = 4, max = 50)
  @Column(nullable = false)
  private String title;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(String title) {
    this.title = title;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Book");
    sb.append("{id=").append(id);
    sb.append(", title='").append(title);
    sb.append('}');
    return sb.toString();
  }
}
