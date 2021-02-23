class Expense {
  final String _id;
  String _description;
  String _dueDate;
  String _paymentDate;
  String _expenseType;

  Expense(
    this._id, [
    this._description = '',
    this._dueDate = '',
    this._paymentDate = '',
    this._expenseType = '',
  ]);

  // Getter's
  String get id => this._id;
  String get description => this._description;
  String get dueDate => this._dueDate;
  String get paymentDate => this._paymentDate;
  String get expenseType => this._expenseType;

  // Setter's
  set description(String description) => this._description = description;
  set dueDate(String dueDate) => this._dueDate = dueDate;
  set paymentDate(String paymentDate) => this._dueDate = paymentDate;
  set expenseType(String expenseType) => this._expenseType = expenseType;
}