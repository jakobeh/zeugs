package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Playermovement {
	Timer move;
	private int count = 0;

	public Playermovement() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imSpiel) {
					if (Var.duck == false) {
						if (Var.dickeX < Var.borderR) {
							if (Var.moveright && Var.moveleft == false) {
								if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
									Var.dickeX += Var.dickeSpeed;
									Var.dickeRealX += Var.dickeSpeed;
								} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
									Var.dickeX += Var.dickeSpeed;
									Var.dickeRealX += Var.dickeSpeed;
									if (count == 4) {
										Var.dickeSpeed += Var.dickeAcc;
										count = 0;
									} else if (count < 4) {
										count++;
									}
								}
							}
						}
						if (Var.dickeX > Var.borderL) {
							if (Var.moveleft && Var.moveright == false) {
								if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
									Var.dickeX -= Var.dickeSpeed;
									Var.dickeRealX -= Var.dickeSpeed;
								} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
									Var.dickeX -= Var.dickeSpeed;
									Var.dickeRealX -= Var.dickeSpeed;
									if (count == 4) {
										Var.dickeSpeed += Var.dickeAcc;
										count = 0;
									} else if (count < 4) {
										count++;
									}
								}
							}
						}

					} else if (Var.duck) {
						if (Var.dickeX < Var.borderR) {
							if (Var.moveright && Var.moveleft == false) {
								if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
									Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
									Var.dickeX += Var.dickeSpeed;
									Var.dickeRealX += Var.dickeSpeed;
								} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
									Var.dickeX += Var.dickeSpeed;
									Var.dickeRealX += Var.dickeSpeed;
								} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
									Var.dickeX += Var.dickeSpeed;
									Var.dickeRealX += Var.dickeSpeed;
									if (count == 4) {
										Var.dickeSpeed += Var.dickeAcc;
										count = 0;
									} else if (count < 4) {
										count++;
									}
								}
							}
						}
						if (Var.dickeX > Var.borderL) {
							if (Var.moveleft && Var.moveright == false) {
								if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
									Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
									Var.dickeX += Var.dickeSpeed;
									Var.dickeRealX += Var.dickeSpeed;
								} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
									Var.dickeX -= Var.dickeSpeed;
									Var.dickeRealX -= Var.dickeSpeed;
								} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
									Var.dickeX -= Var.dickeSpeed;
									Var.dickeRealX -= Var.dickeSpeed;
									if (count == 4) {
										Var.dickeSpeed += Var.dickeAcc;
										count = 0;
									} else if (count < 4) {
										count++;
									}
								}
							}
						}
					}
					if ((Var.moveright == false && Var.moveleft == false) || (Var.moveright && Var.moveleft)) {
						Var.dickeSpeed = 0;
						count = 0;
					}

				}
			}
		}, 0, Var.rate);
	}

}
