package com.podomarket.entity.region;

import com.podomarket.entity.user.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ActiveRegion implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(nullable = false)
    private Users user;

    @OneToOne
    @JoinColumn(nullable = false)
    private Town town;
}
