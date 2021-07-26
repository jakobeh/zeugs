package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class backgroundMovement {
	Timer bmove;
	private int bcount = 0;

	public backgroundMovement() {
		bmove = new Timer();
		bmove.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (Var.imSpiel) {
					// b1
					if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
						if (Var.b1_1X <= -3600) {
							Var.b1_1X = 3600;
						}
						if (Var.b1_2X <= -3600) {
							Var.b1_2X = 3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.b1_1X -= Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X -= Var.b1RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b1_1X -= Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X -= Var.b1RelativeSpeed * Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.b1_1X -= Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X -= Var.b1RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.b1_1X -= Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X -= Var.b1RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b1_1X -= Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X -= Var.b1RelativeSpeed * Var.dickeSpeed;
							}
						}
					}

					else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
						if (Var.b1_1X >= 3600) {
							Var.b1_1X = -3600;
						}
						if (Var.b1_2X >= 3600) {
							Var.b1_2X = -3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.b1_1X += Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X += Var.b1RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b1_1X += Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X += Var.b1RelativeSpeed * Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.b1_1X += Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X += Var.b1RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.b1_1X += Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X += Var.b1RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b1_1X += Var.b1RelativeSpeed * Var.dickeSpeed;
								Var.b1_2X += Var.b1RelativeSpeed * Var.dickeSpeed;
							}
						}
					}
					// b2
					if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
						if (Var.b2_1X <= -3600) {
							Var.b2_1X = 3600;
						}
						if (Var.b2_2X <= -3600) {
							Var.b2_2X = 3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.b2_1X -= Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X -= Var.b2RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b2_1X -= Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X -= Var.b2RelativeSpeed * Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.b2_1X -= Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X -= Var.b2RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.b2_1X -= Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X -= Var.b2RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b2_1X -= Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X -= Var.b2RelativeSpeed * Var.dickeSpeed;
							}
						}
					}

					else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
						if (Var.b2_1X >= 3600) {
							Var.b2_1X = -3600;
						}
						if (Var.b2_2X >= 3600) {
							Var.b2_2X = -3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.b2_1X += Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X += Var.b2RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b2_1X += Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X += Var.b2RelativeSpeed * Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.b2_1X += Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X += Var.b2RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.b2_1X += Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X += Var.b2RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b2_1X += Var.b2RelativeSpeed * Var.dickeSpeed;
								Var.b2_2X += Var.b2RelativeSpeed * Var.dickeSpeed;
							}
						}
					}
					// b3
					if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
						if (Var.b3_1X <= -3600) {
							Var.b3_1X = 3600;
						}
						if (Var.b3_2X <= -3600) {
							Var.b3_2X = 3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.b3_1X -= Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X -= Var.b3RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b3_1X -= Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X -= Var.b3RelativeSpeed * Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.b3_1X -= Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X -= Var.b3RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.b3_1X -= Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X -= Var.b3RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b3_1X -= Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X -= Var.b3RelativeSpeed * Var.dickeSpeed;
							}
						}
					}

					else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
						if (Var.b3_1X >= 3600) {
							Var.b3_1X = -3600;
						}
						if (Var.b3_2X >= 3600) {
							Var.b3_2X = -3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.b3_1X += Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X += Var.b3RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b3_1X += Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X += Var.b3RelativeSpeed * Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.b3_1X += Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X += Var.b3RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.b3_1X += Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X += Var.b3RelativeSpeed * Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.b3_1X += Var.b3RelativeSpeed * Var.dickeSpeed;
								Var.b3_2X += Var.b3RelativeSpeed * Var.dickeSpeed;
							}
						}
					}
					// Vordergrund
					if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
						if (Var.f_1X <= -3600) {
							Var.f_1X = 3600;
						}
						if (Var.f_2X <= -3600) {
							Var.f_2X = 3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.f_1X -= Var.dickeSpeed;
								Var.f_2X -= Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.f_1X -= Var.dickeSpeed;
								Var.f_2X -= Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.f_1X -= Var.dickeSpeed;
								Var.f_2X -= Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.f_1X -= Var.dickeSpeed;
								Var.f_2X -= Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.f_1X -= Var.dickeSpeed;
								Var.f_2X -= Var.dickeSpeed;
							}
						}
					}

					else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
						if (Var.f_1X >= 3600) {
							Var.f_1X = -3600;
						}
						if (Var.f_2X >= 3600) {
							Var.f_2X = -3600;
						}
						if (Var.duck == false) {
							if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
								Var.f_1X += Var.dickeSpeed;
								Var.f_2X += Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.f_1X += Var.dickeSpeed;
								Var.f_2X += Var.dickeSpeed;
							}
						} else if (Var.duck) {
							if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
								Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
								Var.f_1X += Var.dickeSpeed;
								Var.f_2X += Var.dickeSpeed;
							} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
								Var.f_1X += Var.dickeSpeed;
								Var.f_2X += Var.dickeSpeed;
							} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
								if (bcount == 4) {
									Var.dickeSpeed += Var.dickeAcc;
									bcount = 0;
								} else if (bcount < 4) {
									bcount++;
								}
								Var.f_1X += Var.dickeSpeed;
								Var.f_2X += Var.dickeSpeed;
							}
						}
					}
				}
			}
		}, 0, Var.rate);

	}
}
