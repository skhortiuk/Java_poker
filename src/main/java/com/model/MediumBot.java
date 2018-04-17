package com.model;

import java.util.ArrayList;

public class MediumBot implements Bot {


    private Combinations combinations = new Combinations();

    @Override

    public int think(ArrayList<Card> cards, int stack, int bank, int prevRate) {
        combinations.setCards(cards);
        combinations.calculate();

        int firstCardValue = cards.get(0).getValue();
        int secondCardValue = cards.get(1).getValue();


        double power = combinations.getPower();


        if (cards.size() == 2) {



            if (ifCanCheck(prevRate)) {

                if (power > 28) {
                    return 150;
                }
                if (power > 20) {
                    return 100;
                }

                if (ifConnectors(firstCardValue,secondCardValue)) {
                    if (firstCardValue >= 10) {
                        return 100;
                    }
                    if (firstCardValue < 7) {
                        return -1;
                    }
                    else return 0;
                }

                if (firstCardValue >= 12 && secondCardValue >= 10) {
                    return 100;
                }
                if (firstCardValue >= 10 && secondCardValue >= 8) {
                    return 50;
                } else return 0;
            }


            if (prevRate > 0) {
                if (power > 30) {
                    if (bank <= 300) {
                        return prevRate + 200;
                    } else return prevRate;
                }
                if (power > 20) {
                    return prevRate;
                }


                if (ifConnectors(firstCardValue,secondCardValue)) {
                    if (firstCardValue >= 12) {
                        if (bank < 200) {
                            return prevRate + 100;
                        } else return prevRate;

                    }
                    if (firstCardValue < 9) {
                        return -1;
                    }
                    else return prevRate;
                }

                if (firstCardValue >= 13 && secondCardValue >= 11) {
                    if (bank <= 400) {
                        return prevRate + 100;
                    } else return prevRate;
                }
                if (firstCardValue >= 11 && secondCardValue >= 9) {
                    return prevRate;
                } else return -1;

            }

        }

        if (cards.size() == 5) {


            if (ifCanCheck(prevRate)) {
                if (power >= 60) {
                    if (stack >= 800) {
                        return prevRate + 200;
                    } else return prevRate;
                }
                if (power >= 40) {
                    if (stack >= 100) {
                        return prevRate + 100;
                    } else return prevRate;
                }
                if (power >= 30) {
                    if (bank <= 500) {
                        return prevRate + 100;
                    } else return prevRate;
                }
                else {
                    return 0;
                }
            }

            if (prevRate > 150) {
                if (power >= 70) {
                    if (stack > 600) {
                        return prevRate + 250;
                    } else return prevRate;
                }
                if (power >= 40) {
                    if (bank <= 900) {
                        return prevRate + 150;
                    } else return prevRate;

                }

                if (power >= 32) {
                    if (bank <= 600) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }
                if (power >= 28) {
                    if (bank <= 400) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }

            }
            if (prevRate <= 150) {
                if (power >= 70) {
                    if (stack > 800) {
                        return prevRate + 200;
                    } else return prevRate;
                }
                if (power >= 40) {
                    if (bank <= 800) {
                        if (stack > 700) {
                            return prevRate + 150;
                        } else return prevRate;
                    }
                    if (bank <= 1200) {
                        return prevRate;

                    } else {
                        return -1;
                    }
                }

                if (power >= 30) {
                    if (bank <= 500) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }
                if (power >= 20) {
                    if (bank <= 300) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }

            }
        }

        if (cards.size() == 6 || cards.size() == 7) {

            if (ifCanCheck(prevRate)) {
                if (power >= 60) {
                    if (stack >= 475) {
                        return 250;
                    } else return stack;
                }
                if (power >= 50) {
                    if (stack >= 275) {
                        return 200;
                    } else return stack;
                }
                if (stack >= 500) {

                    if (power >= 40) {

                        return 150;
                    }
                    if (power >= 30) {
                        return 100;
                    }
                    if (power >= 25) {
                        return 50;
                    }
                    else {
                        return 0;
                    }
                }
            }
            if (prevRate > 150) {
                if (power >= 90) {
                    if (stack > 600) {
                        return prevRate + 250;
                    } else return prevRate;
                }
                if (power >= 70) {
                    if (bank <= 1600 && stack > 600) {
                        return prevRate + 250;
                    } else return prevRate;
                }
                if (power >= 50) {
                    if (bank <= 1400) {
                        if (stack > 500) {
                            return prevRate + 100;
                        } else return prevRate;
                    } else {
                        return -1;
                    }
                }
                if (power >= 40) {
                    if (bank <= 1200) {
                        return prevRate;
                    } else return -1;
                }
                if (power >= 30) {
                    if (bank <= 950) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }
                if (power >= 20) {
                    if (bank <= 650) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }

            }
            if (prevRate <= 150) {
                if (power >= 90) {
                    if (stack >= 650) {
                        if (bank <= 1900) {
                            return prevRate + 200;
                        } else return prevRate;
                    } else return stack;
                }
                if (power >= 70) {
                    if (stack >= 375) {
                        if (bank <= 1600) {
                            return prevRate + 150;
                        } else return prevRate;
                    } else return stack;
                }
                if (power >= 50) {
                    if (bank <= 800) {
                        if (stack >= 300) {
                                return prevRate+100;
                        } else return stack;
                    }
                    if (bank <= 1300) {
                        if (stack >= prevRate) {
                            return prevRate;
                        }else return -1;

                    } else {
                        return -1;
                    }
                }
                if (stack >= 600) {
                    if (power >= 40) {
                        if (bank <= 1000) {
                            return prevRate + 50;
                        } else return prevRate;
                    }
                    if (power >= 30) {
                        if (bank <= 800) {
                            return prevRate;
                        } else {
                            return -1;
                        }
                    }
                    if (power >= 20) {
                        if (bank <= 550) {
                            return prevRate;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        }

        if (stack == 0) {
            return 0;
        }
        if (prevRate == 0) {
            return 0;
        }

        return -1;
    }

    private boolean ifCanCheck(int prevRate) {

        if (prevRate == 0) {

            return true;
        }
        else return false;
    }
    private boolean ifConnectors(int firstCardValue, int secondCardValue){
        if (firstCardValue + 1 == secondCardValue){
            return true;
        }
        else return false;
    }
}
