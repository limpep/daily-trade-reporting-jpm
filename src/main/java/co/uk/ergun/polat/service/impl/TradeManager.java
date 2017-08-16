package co.uk.ergun.polat.service.impl;

import co.uk.ergun.polat.model.Trade;
import co.uk.ergun.polat.model.TradeDTO;
import co.uk.ergun.polat.model.TradeType;
import co.uk.ergun.polat.util.DateCheckerUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created on 16/08/2017.
 */
public class TradeManager {

  public List<Trade> tradeForWorkingDay(List<Trade> incomingTrades) {
    List<Trade> tradeResult = new ArrayList<>();

    if (incomingTrades != null) {
      for (Trade trade : incomingTrades) {
        if (isItWorkingDay(trade)) {
          tradeResult.add(trade);
        } else {
          tradeResult.add(addAdjustedTrade(trade));
        }
      }
    }
    return tradeResult;
  }

  public List<Trade> rankTradesByIncomingAmount(List<Trade> incomingTrade) {
      return rankTrades(TradeType.SELL, incomingTrade);
  }

  public List<Trade> rankTradesByOutgoingAmount(List<Trade> incomingTrade) {
    return rankTrades(TradeType.BUY, incomingTrade);
  }

  public void tradeCost(TradeDTO dto) {
    Map<LocalDate, BigDecimal> incomingDailyTrade = new HashMap<>();
    Map<LocalDate, BigDecimal> outgoingDailyTrade = new HashMap<LocalDate, BigDecimal>();

    for (Trade trade: dto.getManagedTrades()) {

      if (TradeType.SELL.equals(trade.getTradeType())) {

        if (incomingDailyTrade.get(trade.getSettlementDate()) == null) {

          incomingDailyTrade.put(trade.getSettlementDate(), trade.currencyUSDAmount());

        } else {

          BigDecimal oldTradeValue = incomingDailyTrade.get(trade.getSettlementDate());

          incomingDailyTrade.put(trade.getSettlementDate(),
              oldTradeValue.add(trade.currencyUSDAmount()));
        }
      } else {
        if (TradeType.BUY.equals(trade.getTradeType())) {
          if (outgoingDailyTrade.get(trade.getSettlementDate()) == null) {
            outgoingDailyTrade.put(trade.getSettlementDate(), trade.currencyUSDAmount());
          } else {
            BigDecimal oldTradeValue = outgoingDailyTrade.get(trade.getSettlementDate());

            outgoingDailyTrade.put(trade.getSettlementDate(),
                oldTradeValue.add(trade.currencyUSDAmount()));
          }
        }
      }
    }

    dto.setIncomingDaily(incomingDailyTrade);
    dto.setOutgoingDaily(outgoingDailyTrade);

  }


  private boolean isItWorkingDay(Trade trade) {
    return trade.getCurrency() == null || trade.getSettlementDate() == null || !DateCheckerUtil
        .isWeekend(trade.getSettlementDate(), trade.getCurrency());
  }


  private Trade addAdjustedTrade(Trade trade) {
    Trade copyTrade = new Trade(trade);
    copyTrade.setSettlementDate(DateCheckerUtil
        .shifted(trade.getSettlementDate(), trade.getCurrency()));
    return copyTrade;
  }

  private List<Trade> rankTrades(TradeType type, List<Trade> incomingTrade) {
    List<Trade> sortedTrade = new ArrayList<>();

    for (Trade trade: incomingTrade) {
      if(type.equals(trade.getTradeType())) {
        sortedTrade.add(trade);
      }
    }

    Collections.sort(sortedTrade);
    Set<Trade> uniqueTrades = new HashSet<>(sortedTrade);
    List<Trade> uniqueSortedTrades = new ArrayList<>(uniqueTrades);
    Collections.sort(uniqueSortedTrades);

    return uniqueSortedTrades;



  }

}
