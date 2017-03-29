package me.jurik99.controller;

import me.jurik99.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController
{
	// --- Inject the properties values into StudentController ---
	// TODO: annotation below reads data from the properties file
//	@Value("#{countryOptions}")
	private Map<String, String> coutryOptions;

	@RequestMapping("/showForm")
	public String showForm(final Model model)
	{
		// --- create a student object ---
		final Student theStudent = new Student();

		// --- add student object to the model ---
		model.addAttribute("student", theStudent);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") final Student student)
	{
		// --- log the input data ---
		System.out.println("Student: "
		                   + student.getFirstName()
		                   + ", "
		                   + student.getLastName()
		                   + ", "
		                   + student.getCountry()
		                   + ", "
		                   + student.getFavoriteLanguage()
		                   + ", "
		                   + Arrays.toString(student.getOperatingSystem()));

		return "student-confirmation";
	}

	@RequestMapping("/showFormWithPropertiesFile")
	public String showFormWithPropertiesFile(final Model model)
	{
		// --- create a student object ---
		final Student theStudent = new Student();

		// --- add student object to the model ---
		model.addAttribute("student", theStudent);

		// --- add the country options to the model ---
		model.addAttribute("theCountryOptions", coutryOptions);

		return "student-form-properties";
	}
}
