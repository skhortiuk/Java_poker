package model;

import java.util.ArrayList;

public class MediumBot implements Bot {


    Combinations combinations = new Combinations();

    @Override

    public int think(ArrayList<Card> cards, int stack, int bank, int prevRate) {
        combinations.setCards(cards);
        combinations.calculate();

        int firstCardValue = cards.get(0).getValue();
        int secondCardValue = cards.get(1).getValue();


        double power = combinations.getPower();


//            pre flop
        if (cards.size() == 2) {



            if (ifCanCheck(prevRate)) {

//                high pair\\bet
                if (power > 28) {
                    return 150;
                }
//                small pair\\bet
                if (power > 20) {
                    return 100;
                }

                if (ifConnectors(firstCardValue,secondCardValue)) {
//                    good connectors\\bet
                    if (firstCardValue >= 10) {
                        return 100;
                    }
//                    bad connectors\\fold
                    if (firstCardValue < 7) {
                        return -1;
                    }
//                    simple connectors\\check
                    else return 0;
                }

//                good cards Q-10 and higher\\bet
                if (firstCardValue >= 12 && secondCardValue >= 10) {
                    return 100;
                }
//               cards 10-8 and higher\\small bet
                if (firstCardValue >= 10 && secondCardValue >= 8) {
                    return 50;
                } else return 0;
            }


//                  If need call;
            if (prevRate > 0) {
//                    high pair\\bet
                if (power > 30) {
                    if (bank <= 300) {
                        return prevRate + 200;
                    } else return prevRate;
                }
//                    simple pair\\check
                if (power > 20) {
                    return prevRate;
                }


                if (ifConnectors(firstCardValue,secondCardValue)) {
//                    good connectors\\bet
                    if (firstCardValue >= 12) {
                        if (bank < 200) {
                            return prevRate + 100;
                        } else return prevRate;

                    }
//                    bad connectors\\fold
                    if (firstCardValue < 9) {
                        return -1;
                    }
//                    simple connectors\\check
                    else return prevRate;
                }

//                good cards k-j and higher\\bet
                if (firstCardValue >= 13 && secondCardValue >= 11) {
                    if (bank <= 400) {
                        return prevRate + 100;
                    } else return prevRate;
                }
//               cards 10-8 and higher\\small bet
                if (firstCardValue >= 11 && secondCardValue >= 9) {
                    return prevRate;
                } else return -1;

            }

        }

//            pre flop end;


//          flop

        if (cards.size() == 5) {


            if (ifCanCheck(prevRate)) {
//                    if have 3 of a kind or higher\\bet
                if (power >= 60) {
                    if (stack >= 800) {
                        return prevRate + 200;
                    } else return prevRate;
                }
//                    if have 2 pairs nad higher\\bet
                if (power >= 40) {
                    if (stack >= 100) {
                        return prevRate + 100;
                    } else return prevRate;
                }
//                    if have 1 pairs 10 or higher\\bet
                if (power >= 30) {
                    if (bank <= 500) {
                        return prevRate + 100;
                    } else return prevRate;
                }
//                if have simple hand
                else {
                    return 0;
                }
            }

            //            if need big call
            if (prevRate > 150) {
//                    if have good cards;
                if (power >= 70) {
                    if (stack > 600) {
                        return prevRate + 250;
                    } else return prevRate;
                }
//                    if have 2 pairs for call at flop;
                if (power >= 40) {
//                        if small bank in game
                    if (bank <= 900) {
                        return prevRate + 150;
                    } else return prevRate;

                }

//                    if have 1 high pair at flop to call;
                if (power >= 32) {
                    if (bank <= 600) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }
//                    if have 1 high pair at flop to call;
                if (power >= 28) {
                    if (bank <= 400) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }

            }
//                end need big call;

//            if need small call
            if (prevRate <= 150) {
//                    if have good cards;
                if (power >= 70) {
                    if (stack > 800) {
                        return prevRate + 200;
                    } else return prevRate;
                }
//                    if have 2 pairs for call at flop;
                if (power >= 40) {
//                        if small bank in game
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

//                    if have 1 high pair at flop to call;
                if (power >= 30) {
                    if (bank <= 500) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }
//                    if have 1 pair at flop to call;
                if (power >= 20) {
                    if (bank <= 300) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }

            }
//                end need small call;


//          end flop;
        }


//            turn and river
        if (cards.size() == 6 || cards.size() == 7) {

//            if can check
            if (ifCanCheck(prevRate)) {
//                    if have 3 of a kind or higher\\bet
                if (power >= 60) {
                    if (stack >= 475) {
                        return 250;
                    } else return stack;
                }
//                    if have 2 high pairs nad higher\\bet
                if (power >= 50) {
                    if (stack >= 275) {
                        return 200;
                    } else return stack;
                }
                if (stack >= 500) {

//                       if have 2 high pairs nad higher\\bet
                    if (power >= 40) {

                        return 150;
                    }
//                       if have 1 pairs 10 or higher\\bet
                    if (power >= 30) {
                        return 100;
                    }
//                       if have 1 small pair\\bet
                    if (power >= 25) {
                        return 50;
                    }
//                       if have simple hand\\check
                    else {
                        return 0;
                    }
                }
            }


//                if need big call
            if (prevRate > 150) {
//                    if have good cards;
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

//                    if have 2 pairs for call at turn or river;
                if (power >= 50) {
//                        if small bank in game
                    if (bank <= 1400) {
                        if (stack > 500) {
                            return prevRate + 100;
                        } else return prevRate;
                    } else {
                        return -1;
                    }
                }
//                    if have 2 small pairs at turn or river;
                if (power >= 40) {
                    if (bank <= 1200) {
                        return prevRate;
                    } else return -1;
                }

//                    if have 1 high pair at turn and river to call;
                if (power >= 30) {
                    if (bank <= 950) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }
//                    if have 1 high pair at flop to call;
                if (power >= 20) {
                    if (bank <= 650) {
                        return prevRate;
                    } else {
                        return -1;
                    }
                }

            }
//                end need big call;


//                if need small call
            if (prevRate <= 150) {
//                    if have good cards;
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

//                    if have 2 pairs for call at turn or river;
                if (power >= 50) {
//                        if small bank in game
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
//                       if have 2 small pairs at turn or river;
                    if (power >= 40) {
                        if (bank <= 1000) {
                            return prevRate + 50;
                        } else return prevRate;
                    }

//                       if have 1 high pair at turn and river to call;
                    if (power >= 30) {
                        if (bank <= 800) {
                            return prevRate;
                        } else {
                            return -1;
                        }
                    }
//                        if have 1 high pair at flop to call;
                    if (power >= 20) {
                        if (bank <= 550) {
                            return prevRate;
                        } else {
                            return -1;
                        }
                    }
                }
            }
//                end need small call;


//                    end action for pre-flop, flop, turn and river;
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
