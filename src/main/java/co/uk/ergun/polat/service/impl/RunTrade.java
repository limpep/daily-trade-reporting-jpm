package co.uk.ergun.polat.service.impl;

import co.uk.ergun.polat.model.Trade;
import co.uk.ergun.polat.model.TradeDTO;
import co.uk.ergun.polat.service.TradeService;
import java.util.List;

/**
 * Created on 16/08/2017.
 */
public class RunTrade {

  private TradeDTO dto = new TradeDTO();

  private CreateReport createReport = new CreateReport();
  private TradeService tradeService;
  private TradeManager tradeManager = new TradeManager();

  public RunTrade(TradeService tradeService) {
    this.tradeService = tradeService;
  }

  public void executeTrade (){
    List<Trade> trades = tradeService.getTades();
    dto.setManagedTrades(tradeManager.tradeForWorkingDay(trades));
    tradeManager.tradeCost(dto);
  }

  public void generateReport(){
    createReport.printAmountSettled("Incoming", dto.getIncomingDaily());
    createReport.printAmountSettled("Outgoing", dto.getOutgoingDaily());

    createReport.printRankIncomingTrade(tradeManager
        .rankTradesByIncomingAmount(dto.getManagedTrades()));

    createReport.printRankOutgoingTrade(tradeManager
        .rankTradesByOutgoingAmount(dto.getManagedTrades()));
  }
}
