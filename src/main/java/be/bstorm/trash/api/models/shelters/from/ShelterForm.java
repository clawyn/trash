package be.bstorm.trash.api.models.shelters.from;

import be.bstorm.trash.dl.entities.Shelter;

public record ShelterForm (
        String name,
        String description

){
    public Shelter toShelter (){
        return new Shelter(this.name, this.description);
    }
}

