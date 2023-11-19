package ch.hearc.ig.guideresto.application;

import ch.hearc.ig.guideresto.persistence.FakeItems;
import ch.hearc.ig.guideresto.presentation.CLI;
import ch.hearc.ig.guideresto.service.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var cityService = new CityService();
    var BasicEvaluationService = new BasicEvaluationService();
    var completeEvaluationService = new CompleteEvaluationService();
    var restaurantTypeService = new RestaurantTypeService();
    var restaurantService = new RestaurantService();
    var evaluationCriteriaService = new EvaluationCriteriaService();

    var printStream = System.out;
    var cli = new CLI(scanner, printStream, cityService,
            completeEvaluationService, BasicEvaluationService, restaurantTypeService, restaurantService,
            evaluationCriteriaService);
    cli.start();
  }
}
