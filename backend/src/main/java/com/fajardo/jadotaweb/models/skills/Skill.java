package com.fajardo.jadotaweb.models.skills;

import javax.validation.constraints.NotNull;

import com.fajardo.jadotaweb.enums.DamageType;
import com.fajardo.jadotaweb.enums.SkillType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    
    @NotNull(message = "Name is required")
    private String skillName;

    @NotNull(message = "Image is required")
    private String imgUrl;

    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Type is required")
    private SkillType skillType;

    @NotNull(message = "Damage Type is required")
    private DamageType dmgType;
}
