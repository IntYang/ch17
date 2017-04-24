package ch17.exam39;
//2017.04.21 수업 내용

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {

	 @FXML
	 private ProgressBar progressBar;
	 @FXML
	 private Label lblWorkDone;
	 @FXML
	 private Label lblResult;
	 @FXML
	 private Button btnStart;
	 @FXML
	 private Button btnStop;

	 private TimeService timeService;
	
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
			btnStart.setOnAction(e->handleBtnStart(e));
			btnStop.setOnAction(e->handleBtnStop(e));
	 }	 

	 // 자바 FX 스레드에서 실행
	 private void handleBtnStart(ActionEvent e) {
			if(timeService == null){
				 timeService = new TimeService();
				 timeService.start();
			}
			else{
				 timeService.restart();
			}
			
	 }

	 private void handleBtnStop(ActionEvent e) {
			 timeService.cancel(); //
	 
	 }
	 
	 class TimeService extends Service<Integer>{

			@Override
			protected Task<Integer> createTask() { 
				 // 어떤 작업을 할 것인가, 작업을 생성해라.
				 Task<Integer> task = new Task<Integer>(){
						@Override
						protected Integer call() throws Exception { // 작업 스레드가 실행
							 
							 int sum = 0;
							 for(int i =1 ; i<=100;i++){
									sum+=i;
									
									if(isCancelled()) //  stop버튼 위해서
										 break;
									
									try{
									Thread.sleep(100); // 빨리 도니까 좀 지연시킴
									}catch(Exception e){}
									
									int value = i; // 여기서 final이 되어도 상관없음.
									Platform.runLater(()->{
										 // 프로그레스바와 라벨의 텍스트를 가져오게끔
										// progressBar.setProgress(i/100); //i가 파이널이 될수없다 final이라
										 progressBar.setProgress((double)value/100); // 정수/정수 = 정수라 나누면 값이 순차적으로 오르지 않으므로 변환
										 lblWorkDone.setText(String.valueOf(value));
									});
							 } // 언제 종료? -> 완료되면 자동적으로 실행되는 callback : service에서 막바로 작성
							 return sum;
						}
						
				 };
				 return task;
				 
			}

			@Override
			protected void succeeded() { //자바FX 스레드 - > UI 변경 일어남
				 lblResult.setText(String.valueOf(getValue())); // 서비스가 리턴한 값
			}

			@Override
			protected void cancelled() {
				
			}

			@Override
			protected void failed() {
			}
			
			
			
			
			
			
	 }
	 
}
