package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerMovement {
	Timer gmove;
	private int bcount = 0;

	public GegnerMovement() {
		Var.coin1 = new Coin();
		Var.coin2 = new Coin();
		
		gmove = new Timer();
		gmove.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// Pilz1

				if (Pilz1.x <= Var.despawnRange) {
					Pilz1.spawn();

				}
				if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {

							Pilz1.x -= Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}

							Pilz1.x -= Var.dickeSpeed;

						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Pilz1.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Pilz1.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Pilz1.x -= Var.dickeSpeed;
						}
					}
				}

				else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
							Pilz1.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Pilz1.x += Var.dickeSpeed;
						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Pilz1.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Pilz1.x += Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Pilz1.x += Var.dickeSpeed;
						}
					}
				}
				// Coins

				if (Var.coin1.x <= Var.despawnRange) {
					Var.coin1.spawn();

				}
				if (Var.coin2.x <= Var.despawnRange) {
					Var.coin2.spawn();

				}
				if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {

							Var.coin1.x -= Var.dickeSpeed;
							Var.coin2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}

							Var.coin1.x -= Var.dickeSpeed;
							Var.coin2.x -= Var.dickeSpeed;

						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Var.coin1.x -= Var.dickeSpeed;
							Var.coin2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Var.coin1.x -= Var.dickeSpeed;
							Var.coin2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Var.coin1.x -= Var.dickeSpeed;
							Var.coin2.x -= Var.dickeSpeed;
						}
					}
				}

				else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
							Var.coin1.x += Var.dickeSpeed;
							Var.coin2.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Var.coin1.x += Var.dickeSpeed;
							Var.coin2.x += Var.dickeSpeed;
						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Var.coin1.x += Var.dickeSpeed;
							Var.coin2.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Var.coin1.x += Var.dickeSpeed;
							Var.coin2.x += Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Var.coin1.x += Var.dickeSpeed;
							Var.coin2.x += Var.dickeSpeed;
						}
					}
				}
				// Plattformen
				//1
				if (Plattform1.x <= Var.despawnRange) {
					Plattform1.spawn();
			
				}
				
				if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {

							Plattform1.x -= Var.dickeSpeed;
						
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}

							Plattform1.x -= Var.dickeSpeed;

						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Plattform1.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Plattform1.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Plattform1.x -= Var.dickeSpeed;
						}
					}
				}

				else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
							Plattform1.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Plattform1.x += Var.dickeSpeed;
						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Plattform1.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Plattform1.x += Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Plattform1.x += Var.dickeSpeed;
						}
					}
				}
				// Plattformen2

				
				if (Plattform2.x <= Var.despawnRange) {
					Plattform2.spawn();

				}
				if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {

							Plattform2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}

							Plattform2.x -= Var.dickeSpeed;

						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Plattform2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Plattform2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Plattform2.x -= Var.dickeSpeed;
						}
					}
				}

				else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
							Plattform2.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Plattform2.x += Var.dickeSpeed;
						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Plattform2.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Plattform2.x += Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Plattform2.x += Var.dickeSpeed;
						}
					}
				}
				// Pilz2

				if (Pilz2.x <= Var.despawnRange) {
					Pilz2.spawn();

				}
				if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {

							Pilz2.x -= Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}

							Pilz2.x -= Var.dickeSpeed;

						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Pilz2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Pilz2.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Pilz2.x -= Var.dickeSpeed;
						}
					}
				}

				else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
							Pilz2.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Pilz2.x += Var.dickeSpeed;
						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Pilz2.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Pilz2.x += Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Pilz2.x += Var.dickeSpeed;
						}
					}
				}
				
				//Wurm
				if (Wurm.x <= Var.despawnRange) {
					Wurm.spawn();

				}
				if (Var.dickeX >= Var.borderR && Var.moveright && Var.moveleft == false) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {

							Wurm.x -= Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}

							Wurm.x -= Var.dickeSpeed;

						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Wurm.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Wurm.x -= Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Wurm.x -= Var.dickeSpeed;
						}
					}
				}

				else if (Var.dickeX <= Var.borderL && Var.moveright == false && Var.moveleft) {
					if (Var.duck == false) {
						if (Var.dickeSpeed >= Var.dickeMaxSpeed) {
							Wurm.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed < Var.dickeMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Wurm.x += Var.dickeSpeed;
						}
					} else if (Var.duck) {
						if (Var.dickeSpeed > Var.dickeGeducktMaxSpeed) {
							Var.dickeSpeed = Var.dickeGeducktMaxSpeed;
							Wurm.x += Var.dickeSpeed;
						} else if (Var.dickeSpeed == Var.dickeGeducktMaxSpeed) {
							Wurm.x += Var.dickeSpeed;

						} else if (Var.dickeSpeed < Var.dickeGeducktMaxSpeed) {
							if (bcount == 4) {
								Var.dickeSpeed += Var.dickeAcc;
								bcount = 0;
							} else if (bcount < 4) {
								bcount++;
							}
							Wurm.x += Var.dickeSpeed;
						}
					}
				}
			}

		}, 0, Var.rate);
	}

}
