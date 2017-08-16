package co.uk.ergun.polat.service.impl;

import co.uk.ergun.polat.model.Trade;
import co.uk.ergun.polat.util.DateCheckerUtil;
import java.util.List;

/**
 * Created on 16/08/2017.
 */
public class TradeManager {

  public List<Trade> tradeForWorkingDat(List<Trade> incomingTrades){


  }


  public Trade addAdjustedTrade(Trade trade) {
    Trade copyTrade = new Trade(trade);
    copyTrade.setSettlementDate(DateCheckerUtil
        .shifted(trade.getSettlementDate(), trade.getCurrency()));
    return copyTrade;

  }

}
