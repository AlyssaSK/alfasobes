package ru.alfasobes.alfasobes.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
public class Interview {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InterviewQuestion> interviewQuestions = new LinkedList<>();

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    private InterviewStatus status = InterviewStatus.CREATED;

    public String getFinishDateString(){
        if (date != null){
            return new SimpleDateFormat("dd.MM.yyyy").format(date);
        }
        return StringUtils.EMPTY;
    }

}
