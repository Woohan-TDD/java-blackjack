package controller;

import static java.util.stream.Collectors.*;

import java.util.List;

import domain.card.deck.Deck;
import domain.card.deck.DeckFactory;
import domain.card.deck.RandomShuffledDeckFactory;
import domain.gamer.Dealer;
import domain.gamer.Player;
import domain.gamer.Players;
import dto.GamerDto;
import dto.GamerEarningDto;
import dto.GamerWithScoreDto;
import dto.PlayerInfo;
import view.InputView;
import view.OutputView;

public class BlackJackController {
	private final InputView inputView;
	private final OutputView outputView;

	public BlackJackController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Deck deck = getDeck();
		Players players = getPlayers(deck);
		Dealer dealer = Dealer.of(deck);
		playBlackJack(deck, players, dealer);
		printResult(players, dealer);
	}

	private void playBlackJack(Deck deck, Players players, Dealer dealer) {
		outputView.printGamersCards(GamerDto.listOf(dealer, players.getPlayers()));
		for (Player player : players.getPlayers()) {
			decideHitOrStay(deck, player);
		}
		decideDealerHit(deck, dealer);
	}

	private void decideDealerHit(Deck deck, Dealer dealer) {
		while (dealer.canHit()) {
			outputView.printDealerHit();
			dealer.hit(deck);
		}
	}

	private void decideHitOrStay(Deck deck, Player player) {
		while (player.canHit()) {
			YesOrNo yesOrNo = YesOrNo.findByShortName(inputView.inputYesOrNo(player.getName()));
			yesOrNo.execute(player, deck);
			outputView.printGamerCards(GamerDto.of(player));
		}
	}

	private Players getPlayers(Deck deck) {
		List<PlayerInfo> playerInfos = inputView.inputPlayerInfos();
		return playerInfos.stream()
			.map(playerInfo -> Player.of(playerInfo.getName(), deck, playerInfo.getBattingMoney()))
			.collect(collectingAndThen(toList(), Players::new));
	}

	private Deck getDeck() {
		DeckFactory randomShuffledDeckFactory = new RandomShuffledDeckFactory();
		return randomShuffledDeckFactory.create();
	}

	private void printResult(Players players, Dealer dealer) {
		outputView.printGamersCardsWithScore(GamerWithScoreDto.listOf(dealer, players.getPlayers()));
		outputView.printEarning(GamerEarningDto.listOf(dealer, players));
	}
}
