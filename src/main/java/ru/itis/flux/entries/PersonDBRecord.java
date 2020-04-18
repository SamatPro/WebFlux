package ru.itis.flux.entries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDBRecord {
    private Long id;
    private String name;
    private String birthday;
    private String proffession;
    private String vkcom;
    private String univer;
}
