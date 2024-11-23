package gfg.org.MinorProject1.Digital.Library.dto;

import gfg.org.MinorProject1.Digital.Library.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentRequest {


    private String name;
    private String email;
    private String address;

    public Student toStudent() {
        return Student.builder()
                .name(name)
                .email(email)
                .address(address)
                .build();
    }
}
