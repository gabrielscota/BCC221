package presentation.controllers;

import data.usecases.schedule.LocalAddConsultation;
import data.usecases.schedule.LocalLoadConsultations;
import domain.entities.Clinic;
import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.LoadConsultations;
import ui.pages.home.HomeController;

import java.util.List;

public class PresentationHomeController implements HomeController {
  final Clinic clinic;

  public PresentationHomeController(Clinic clinic) {
    this.clinic = clinic;
  }

  void printTest(){
    System.out.println("Teste");
  }
}
