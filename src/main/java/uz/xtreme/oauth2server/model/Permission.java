package uz.xtreme.oauth2server.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: Rustambekov Avazbek
 * Date: 25/12/2019
 * Time: 18:16
 */
@Entity
@Table(name = "permission")
@Data
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;
}
