//����������� �������� ������ ����������
// sp ������ ������������ ��������� BinFuncProvider
module appstart{
  // ��������� ������ appfuncs
  requires appfuncs;
  // sp ��������� ������ userfuncs
  requires userfuncs;

  // sp ������ appstart ������ ���������� ��������� BinFuncProvider
  uses userfuncs.binaryfuncs.BinFuncProvider;
}