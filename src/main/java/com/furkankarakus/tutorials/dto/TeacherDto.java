package com.furkankarakus.tutorials.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class TeacherDto {
    private Long teacherId;
    @NotEmpty(message = "You cannot leave the name and surname field blank.")
    @Size(min = 1,max = 255)
    private String teacherFullName;
    @NotEmpty(message = "You cannot leave the email field blank.")
    @Email(message = "You did not enter an e-mail in the appropriate format")
    private String teacherEmail;
    @NotEmpty(message = "You cannot pass the password field blank")
    //    @Min(value=10,message="minumum 10 karakter olmalıdır.")
//    @Max(value=18,message="maksimum 18 karakter olmalıdır.")
    @Size(min = 10,max = 22)
    private String teacherPassword;
}
