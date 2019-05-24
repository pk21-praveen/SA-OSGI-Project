package travel.estimator.service;

import java.text.DecimalFormat;

/**
 * @author PraveenKumar
 *
 */
public class TravelEstimatorServiceImpl implements TravelEstimatorService {

	private double timeValue;
	private double speedValue;
	private double distanceValue;
	private String timeType;
	private String speedType;
	private String distanceType;
	private double answer;

	@Override
	public double getTimeValue() {
		return timeValue;
	}

	@Override
	public void setTimeValue(double timeValue) {
		this.timeValue = timeValue;
	}

	@Override
	public double getSpeedValue() {
		return speedValue;
	}

	@Override
	public void setSpeedValue(double speedValue) {
		this.speedValue = speedValue;
	}

	@Override
	public double getDistanceValue() {
		return distanceValue;
	}

	@Override
	public void setDistanceValue(double distanceValue) {
		this.distanceValue = distanceValue;
	}

	@Override
	public String getTimeType() {
		return timeType;
	}

	@Override
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	@Override
	public String getSpeedType() {
		return speedType;
	}

	@Override
	public void setSpeedType(String speedType) {
		this.speedType = speedType;
	}

	@Override
	public String getDistanceType() {
		return distanceType;
	}

	@Override
	public void setDistanceType(String distanceType) {
		this.distanceType = distanceType;
	}

	@Override
	public String displayDistanceAnswer() {
		if (distanceType.equalsIgnoreCase(" Meter")) {

			if (timeType.equalsIgnoreCase(" Seconds")) {

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = speedValue * timeValue;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = (speedValue / 3.6) * timeValue;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = (speedValue / 2.237) * timeValue;
				}

			} else if (timeType.equalsIgnoreCase(" Minutes")) {
				timeValue = timeValue * 60;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = speedValue * timeValue;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = (speedValue / 3.6) * timeValue;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = (speedValue / 2.237) * timeValue;
				}

			} else if (timeType.equalsIgnoreCase(" Hour")) {
				timeValue = timeValue * 3600;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = speedValue * timeValue;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = (speedValue / 3.6) * timeValue;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = (speedValue / 2.237) * timeValue;
				}
			}

		} else if (distanceType.equalsIgnoreCase(" Kilometer")) {

			if (timeType.equalsIgnoreCase(" Seconds")) {

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = (speedValue * timeValue) / 1000.0;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = ((speedValue / 3.6) * timeValue) / 1000.0;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = ((speedValue / 2.237) * timeValue) / 1000.0;
				}
			} else if (timeType.equalsIgnoreCase(" Minutes")) {
				timeValue = timeValue * 60;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = (speedValue * timeValue) / 1000.0;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = ((speedValue / 3.6) * timeValue) / 1000.0;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = ((speedValue / 2.237) * timeValue) / 1000.0;
				}

			} else if (timeType.equalsIgnoreCase(" Hour")) {
				timeValue = timeValue * 3600;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = (speedValue * timeValue) / 1000.0;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = ((speedValue / 3.6) * timeValue) / 1000.0;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = ((speedValue / 2.237) * timeValue) / 1000.0;
				}
			}

		} else if (distanceType.equalsIgnoreCase(" Mile")) {

			if (timeType.equalsIgnoreCase(" Seconds")) {

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = (speedValue * timeValue) / 1609.34;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = ((speedValue / 3.6) * timeValue) / 1609.34;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = ((speedValue / 2.237) * timeValue) / 1609.34;
				}
			} else if (timeType.equalsIgnoreCase(" Minutes")) {
				timeValue = timeValue * 60;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = (speedValue * timeValue) / 1609.34;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = ((speedValue / 3.6) * timeValue) / 1609.34;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = ((speedValue / 2.237) * timeValue) / 1609.34;
				}

			} else if (timeType.equalsIgnoreCase(" Hour")) {
				timeValue = timeValue * 3600;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = (speedValue * timeValue) / 1609.34;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = ((speedValue / 3.6) * timeValue) / 1609.34;

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = ((speedValue / 2.237) * timeValue) / 1609.34;
				}
			}

		}

		String answerValue = String.valueOf(Math.round(answer * 1000) / 1000.0);
		return answerValue;

	}

	@Override
	public String displaySpeedAnswer() {

		if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {

			if (distanceType.equalsIgnoreCase(" Meter")) {

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = distanceValue / timeValue;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = distanceValue / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = distanceValue / (timeValue * 3600);
				}

			} else if (distanceType.equalsIgnoreCase(" Kilometer")) {
				distanceValue = distanceValue * 1000.0;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = distanceValue / timeValue;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = distanceValue / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = distanceValue / (timeValue * 3600);
				}

			} else if (distanceType.equalsIgnoreCase(" Mile")) {
				distanceValue = distanceValue * 1609.34;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = distanceValue / timeValue;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = distanceValue / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = distanceValue / (timeValue * 3600);
				}

			}
		} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {

			if (distanceType.equalsIgnoreCase(" Meter")) {

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (distanceValue / timeValue) * 3.6;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (distanceValue * 3.6) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (distanceValue * 3.6) / (timeValue * 3600);
				}

			} else if (distanceType.equalsIgnoreCase(" Kilometer")) {
				distanceValue = distanceValue * 1000.0;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (distanceValue / timeValue) * 3.6;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (distanceValue * 3.6) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (distanceValue * 3.6) / (timeValue * 3600);
				}

			} else if (distanceType.equalsIgnoreCase(" Mile")) {
				distanceValue = distanceValue * 1609.34;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (distanceValue / timeValue) * 3.6;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (distanceValue * 3.6) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (distanceValue * 3.6) / (timeValue * 3600);
				}

			}
		} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {

			if (distanceType.equalsIgnoreCase(" Meter")) {

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (distanceValue / timeValue) * 2.237;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (distanceValue * 2.237) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (distanceValue * 2.237) / (timeValue * 3600);
				}

			} else if (distanceType.equalsIgnoreCase(" Kilometer")) {
				distanceValue = distanceValue * 1000.0;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (distanceValue / timeValue) * 2.237;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (distanceValue * 2.237) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (distanceValue * 2.237) / (timeValue * 3600);
				}

			} else if (distanceType.equalsIgnoreCase(" Mile")) {
				distanceValue = distanceValue * 1609.34;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (distanceValue / timeValue) * 2.237;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (distanceValue * 2.237) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (distanceValue * 2.237) / (timeValue * 3600);
				}
			}
		}

		String answerValue = String.valueOf(Math.round(answer * 1000) / 1000.0);
		return answerValue;

	}

	@Override
	public String displayTimeAnswer() {
		DecimalFormat df = new DecimalFormat("#.##");
		String answerValue = "";

		if (timeType.equalsIgnoreCase(" Seconds")) {

			if (distanceType.equalsIgnoreCase(" Meter")) {

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = distanceValue / speedValue;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = distanceValue / (speedValue / 3.6);

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = distanceValue / (speedValue / 2.237);
				}

			} else if (distanceType.equalsIgnoreCase(" Kilometer")) {

				distanceValue = distanceValue * 1000.0;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = distanceValue / speedValue;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = distanceValue / (speedValue / 3.6);

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = distanceValue / (speedValue / 2.237);
				}

			} else if (distanceType.equalsIgnoreCase(" Mile")) {

				distanceValue = distanceValue * 1609.34;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {
					answer = distanceValue / speedValue;

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {
					answer = distanceValue / (speedValue / 3.6);

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {
					answer = distanceValue / (speedValue / 2.237);
				}
			}

			answerValue = String.valueOf(Math.round(answer * 1000) / 1000.0) + " Sec";
		}

		if (timeType.equalsIgnoreCase(" Minutes")) {

			if (distanceType.equalsIgnoreCase(" Meter")) {

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {

					double value, minutes, seconds;

					value = (distanceValue / speedValue) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {

					double value, minutes, seconds;

					value = (distanceValue / (speedValue / 3.6)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {

					double value, minutes, seconds;

					value = (distanceValue / (speedValue / 2.237)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}
				}

			} else if (distanceType.equalsIgnoreCase(" Kilometer")) {

				distanceValue = distanceValue * 1000.0;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {

					double value, minutes, seconds;

					value = (distanceValue / speedValue) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {

					double value, minutes, seconds;

					value = (distanceValue / (speedValue / 3.6)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {

					double value, minutes, seconds;

					value = (distanceValue / (speedValue / 2.237)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}
				}

			} else if (distanceType.equalsIgnoreCase(" Mile")) {

				distanceValue = distanceValue * 1609.34;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {

					double value, minutes, seconds;

					value = (distanceValue / speedValue) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {

					double value, minutes, seconds;

					value = (distanceValue / (speedValue / 3.6)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {

					double value, minutes, seconds;

					value = (distanceValue / (speedValue / 2.237)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}
				}
			}
		}

		if (timeType.equalsIgnoreCase(" Hour")) {

			if (distanceType.equalsIgnoreCase(" Meter")) {

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / speedValue) / 3600;

					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;
						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";

					} else {
						return "Hours : " + hours;
					}

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / (speedValue / 3.6)) / 3600;

					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;

						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / (speedValue / 2.237)) / 3600;

					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;

						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}
				}
			} else if (distanceType.equalsIgnoreCase(" Kilometer")) {

				distanceValue = distanceValue * 1000.0;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / speedValue) / 3600;

					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;
						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / (speedValue / 3.6)) / 3600;

					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;
						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / (speedValue / 2.237)) / 3600;
					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;

						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}
				}

			} else if (distanceType.equalsIgnoreCase(" Mile")) {

				distanceValue = distanceValue * 1609.34;

				if (speedType.equalsIgnoreCase("Meter Per Second (m/s)")) {

					double value, hours, minutes, seconds, value2;
					value = (distanceValue / speedValue) / 3600;

					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;
						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}

				} else if (speedType.equalsIgnoreCase("Km Per Hour (kph)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / (speedValue / 3.6)) / 3600;
					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;
						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}

				} else if (speedType.equalsIgnoreCase("Mile Per Hour (mph)")) {

					double value, hours, minutes, seconds, value2;

					value = (distanceValue / (speedValue / 2.237)) / 3600;

					hours = Math.floor(value);

					if ((value - hours) < 1) {
						minutes = (value - hours) * 60;

						value2 = Math.floor(minutes);

						if ((minutes - value2) < 1) {
							seconds = (minutes - value2) * 60;
							minutes = (int) minutes;
							return hours + "H : " + minutes + "M : " + df.format(seconds) + "S";
						}

						return hours + "H : " + df.format(minutes) + "M";
					} else {
						return "Hours : " + hours;
					}

				}
			}
		}

		return answerValue;
	}
}
