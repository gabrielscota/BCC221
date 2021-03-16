#include "../../domain/entities/time_sheet.hpp"

TimeSheet::TimeSheet(string id, vector<Point *> points):
    id(id),
    points(points){};

TimeSheet::~TimeSheet(){}

string TimeSheet::getId(){
    return this->id;
}

vector <Point *> TimeSheet::getPoints(){
    return this->points;
}

void TimeSheet::setPoints(vector<Point *> points){
    this->points = points;
}

