//определение главного модуля приложения
// sp теперь используется интерфейс BinFuncProvider
module appstart{
  // требуется модуль appfuncs
  requires appfuncs;
  // sp требуется модуль userfuncs
  requires userfuncs;

  // sp модуль appstart теперь использует интерфейс BinFuncProvider
  uses userfuncs.binaryfuncs.BinFuncProvider;
}