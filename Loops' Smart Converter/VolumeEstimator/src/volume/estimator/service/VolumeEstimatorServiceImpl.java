package volume.estimator.service;

import java.text.DecimalFormat;

public class VolumeEstimatorServiceImpl implements VolumeEstimatorService {
	
	private double timeValue;
	private double rateValue;
	private double volumeValue;
	private String timeType;
	private String rateType;
	private String volumeType;
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
	public double getRateValue() {
		return rateValue;
	}

	@Override
	public void setRateValue(double rateValue) {
		this.rateValue = rateValue;
	}

	@Override
	public double getVolumeValue() {
		return volumeValue;
	}

	@Override
	public void setVolumeValue(double volumeValue) {
		this.volumeValue = volumeValue;
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
	public String getRateType() {
		return rateType;
	}

	@Override
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	@Override
	public String getVolumeType() {
		return volumeType;
	}

	@Override
	public void setVolumeType(String volumeType) {
		this.volumeType = volumeType;
	}

	@Override
	public String displayTimeAnswer() {
		DecimalFormat df = new DecimalFormat("#.##");
		String answerValue = "";

		if (timeType.equalsIgnoreCase(" Seconds")) {

			if (volumeType.equalsIgnoreCase(" Centimeter")) {

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = volumeValue / rateValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = volumeValue / (rateValue / 3.6);

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = volumeValue / (rateValue / 2.237);
				}

			} else if (volumeType.equalsIgnoreCase(" Meter")) {

				volumeValue = volumeValue * 1000.0;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = volumeValue / rateValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = volumeValue / (rateValue / 3.6);

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = volumeValue / (rateValue / 2.237);
				}

			} else if (volumeType.equalsIgnoreCase(" Feet")) {

				volumeValue = volumeValue * 1609.34;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = volumeValue / rateValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = volumeValue / (rateValue / 3.6);

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = volumeValue / (rateValue / 2.237);
				}
			}

			answerValue = String.valueOf(Math.round(answer * 1000) / 1000.0) + " Sec";
		}

		if (timeType.equalsIgnoreCase(" Minutes")) {

			if (volumeType.equalsIgnoreCase(" Centimeter")) {

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {

					double value, minutes, seconds;

					value = (volumeValue / rateValue) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {

					double value, minutes, seconds;

					value = (volumeValue / (rateValue / 3.6)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {

					double value, minutes, seconds;

					value = (volumeValue / (rateValue / 2.237)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}
				}

			} else if (volumeType.equalsIgnoreCase(" Meter")) {

				volumeValue = volumeValue * 1000.0;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {

					double value, minutes, seconds;

					value = (volumeValue / rateValue) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {

					double value, minutes, seconds;

					value = (volumeValue / (rateValue / 3.6)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {

					double value, minutes, seconds;

					value = (volumeValue / (rateValue / 2.237)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}
				}

			} else if (volumeType.equalsIgnoreCase(" Feet")) {

				volumeValue = volumeValue * 1609.34;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {

					double value, minutes, seconds;

					value = (volumeValue / rateValue) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {

					double value, minutes, seconds;

					value = (volumeValue / (rateValue / 3.6)) / 60;

					minutes = Math.floor(value);

					if ((value - minutes) < 1) {
						seconds = (value - minutes) * 60;
						return minutes + "M : " + df.format(seconds) + "S";
					} else {
						return "Minutes : " + minutes;
					}

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {

					double value, minutes, seconds;

					value = (volumeValue / (rateValue / 2.237)) / 60;

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

			if (volumeType.equalsIgnoreCase(" Centimeter")) {

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / rateValue) / 3600;

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

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / (rateValue / 3.6)) / 3600;

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

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / (rateValue / 2.237)) / 3600;

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
			} else if (volumeType.equalsIgnoreCase(" Meter")) {

				volumeValue = volumeValue * 1000.0;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / rateValue) / 3600;

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

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / (rateValue / 3.6)) / 3600;

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

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / (rateValue / 2.237)) / 3600;
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

			} else if (volumeType.equalsIgnoreCase(" Feet")) {

				volumeValue = volumeValue * 1609.34;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {

					double value, hours, minutes, seconds, value2;
					value = (volumeValue / rateValue) / 3600;

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

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / (rateValue / 3.6)) / 3600;
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

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {

					double value, hours, minutes, seconds, value2;

					value = (volumeValue / (rateValue / 2.237)) / 3600;

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

	@Override
	public String displayVolumeAnswer() {
		if (volumeType.equalsIgnoreCase(" Centimeter")) {

			if (timeType.equalsIgnoreCase(" Seconds")) {

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = rateValue * timeValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = (rateValue / 3.6) * timeValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = (rateValue / 2.237) * timeValue;
				}

			} else if (timeType.equalsIgnoreCase(" Minutes")) {
				timeValue = timeValue * 60;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = rateValue * timeValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = (rateValue / 3.6) * timeValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = (rateValue / 2.237) * timeValue;
				}

			} else if (timeType.equalsIgnoreCase(" Hour")) {
				timeValue = timeValue * 3600;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = rateValue * timeValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = (rateValue / 3.6) * timeValue;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = (rateValue / 2.237) * timeValue;
				}
			}

		} else if (volumeType.equalsIgnoreCase(" Meter")) {

			if (timeType.equalsIgnoreCase(" Seconds")) {

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = (rateValue * timeValue) / 1000.0;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = ((rateValue / 3.6) * timeValue) / 1000.0;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = ((rateValue / 2.237) * timeValue) / 1000.0;
				}
			} else if (timeType.equalsIgnoreCase(" Minutes")) {
				timeValue = timeValue * 60;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = (rateValue * timeValue) / 1000.0;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = ((rateValue / 3.6) * timeValue) / 1000.0;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = ((rateValue / 2.237) * timeValue) / 1000.0;
				}

			} else if (timeType.equalsIgnoreCase(" Hour")) {
				timeValue = timeValue * 3600;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = (rateValue * timeValue) / 1000.0;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = ((rateValue / 3.6) * timeValue) / 1000.0;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = ((rateValue / 2.237) * timeValue) / 1000.0;
				}
			}

		} else if (volumeType.equalsIgnoreCase(" Feet")) {

			if (timeType.equalsIgnoreCase(" Seconds")) {

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = (rateValue * timeValue) / 1609.34;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = ((rateValue / 3.6) * timeValue) / 1609.34;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = ((rateValue / 2.237) * timeValue) / 1609.34;
				}
			} else if (timeType.equalsIgnoreCase(" Minutes")) {
				timeValue = timeValue * 60;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = (rateValue * timeValue) / 1609.34;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = ((rateValue / 3.6) * timeValue) / 1609.34;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = ((rateValue / 2.237) * timeValue) / 1609.34;
				}

			} else if (timeType.equalsIgnoreCase(" Hour")) {
				timeValue = timeValue * 3600;

				if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {
					answer = (rateValue * timeValue) / 1609.34;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {
					answer = ((rateValue / 3.6) * timeValue) / 1609.34;

				} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {
					answer = ((rateValue / 2.237) * timeValue) / 1609.34;
				}
			}

		}

		String answerValue = String.valueOf(Math.round(answer * 1000) / 1000.0);
		return answerValue;

	}

	@Override
	public String displayRateAnswer() {

		if (rateType.equalsIgnoreCase(" Cubic centimeters/second")) {

			if (volumeType.equalsIgnoreCase(" Centimeter")) {

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = volumeValue / timeValue;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = volumeValue / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = volumeValue / (timeValue * 3600);
				}

			} else if (volumeType.equalsIgnoreCase(" Meter")) {
				volumeValue = volumeValue * 1000.0;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = volumeValue / timeValue;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = volumeValue / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = volumeValue / (timeValue * 3600);
				}

			} else if (volumeType.equalsIgnoreCase(" Feet")) {
				volumeValue = volumeValue * 1609.34;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = volumeValue / timeValue;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = volumeValue / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = volumeValue / (timeValue * 3600);
				}

			}
		} else if (rateType.equalsIgnoreCase(" Cubic centimeters/minute")) {

			if (volumeType.equalsIgnoreCase(" Centimeter")) {

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (volumeValue / timeValue) * 3.6;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (volumeValue * 3.6) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (volumeValue * 3.6) / (timeValue * 3600);
				}

			} else if (volumeType.equalsIgnoreCase(" Meter")) {
				volumeValue = volumeValue * 1000.0;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (volumeValue / timeValue) * 3.6;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (volumeValue * 3.6) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (volumeValue * 3.6) / (timeValue * 3600);
				}

			} else if (volumeType.equalsIgnoreCase(" Feet")) {
				volumeValue = volumeValue * 1609.34;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (volumeValue / timeValue) * 3.6;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (volumeValue * 3.6) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (volumeValue * 3.6) / (timeValue * 3600);
				}

			}
		} else if (rateType.equalsIgnoreCase(" Cubic centimeters/hour")) {

			if (volumeType.equalsIgnoreCase(" Centimeter")) {

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (volumeValue / timeValue) * 2.237;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (volumeValue * 2.237) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (volumeValue * 2.237) / (timeValue * 3600);
				}

			} else if (volumeType.equalsIgnoreCase(" Meter")) {
				volumeValue = volumeValue * 1000.0;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (volumeValue / timeValue) * 2.237;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (volumeValue * 2.237) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (volumeValue * 2.237) / (timeValue * 3600);
				}

			} else if (volumeType.equalsIgnoreCase(" Feet")) {
				volumeValue = volumeValue * 1609.34;

				if (timeType.equalsIgnoreCase(" Seconds")) {
					answer = (volumeValue / timeValue) * 2.237;

				} else if (timeType.equalsIgnoreCase(" Minutes")) {
					answer = (volumeValue * 2.237) / (timeValue * 60);

				} else if (timeType.equalsIgnoreCase(" Hour")) {
					answer = (volumeValue * 2.237) / (timeValue * 3600);
				}
			}
		}

		String answerValue = String.valueOf(Math.round(answer * 1000) / 1000.0);
		return answerValue;

	}
}
