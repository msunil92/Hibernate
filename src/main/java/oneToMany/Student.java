package oneToMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "STUDENT_NAME")
	private String name;
	@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="STUDNET_ID"), inverseJoinColumns=@JoinColumn(name="COLLEGE_ID"), name="STUDENT_COLLEGE")
	private Collection<College> listOfColleges = new ArrayList<College>();

	public Student() {
	}

	public Collection<College> getListOfColleges() {
		return listOfColleges;
	}

	public void setListOfColleges(Collection<College> listOfColleges) {
		this.listOfColleges = listOfColleges;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
