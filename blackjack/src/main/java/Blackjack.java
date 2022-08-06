public class Blackjack
{
    public int parseCard(String card)
    {
        int value = 0;
        if (card != null) {
            if (card == "ace") value = 11;
            else if (
                card == "king" || card == "queen" || card == "jack"
                || card == "ten"
            ) value = 10;
            else if (card == "nine") value = 9;
            else if (card == "eight") value = 8;
            else if (card == "seven") value = 7;
            else if (card == "six") value = 6;
            else if (card == "five") value = 5;
            else if (card == "four") value = 4;
            else if (card == "three") value = 3;
            else if (card == "two") value = 2;
            else if (card == "one") value = 1;
        }
        return value;
    }

    public boolean isBlackjack(String card1, String card2)
    {
        return parseCard(card1) + parseCard(card2) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore)
    {
        if (isBlackjack) {
            if (dealerScore < 10) return "W";
            else return "S";
        } else return "P";
    }

    public String smallHand(int handScore, int dealerScore)
    {
        if (handScore < 17 && (handScore <= 11 || dealerScore >= 7)) return "H";
        else return "S";
    }

    // FirstTurn returns the semi-optimal decision for the first turn,
    // given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited.
    // It pulls the other functions together in a complete decision tree.
    public String firstTurn(String card1, String card2, String dealerCard)
    {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
