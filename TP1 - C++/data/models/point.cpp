#include "point.hpp"

Point::Point(string id, string date, string observation):
    id(id),
    date(date),
    observation(observation){};

Point::~Point(){};

string Point::getId(){
    return this->id;
}

string Point::getDate(){
    return this->date;
}

string Point::getObservation(){
    return this->observation;
}

void Point::setDate(string date){
    this->date = date;
}

void Point::setObservation(string observation){
    this->observation = observation;
}