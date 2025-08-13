trait IAccount:
  def getBalance: Int
  def withdraw(amount: Int): Boolean
  def deposit(amount: Int): Boolean

class Account(
    private var balance: Int,
    private val currency: String
) extends IAccount:
  override def getBalance: Int = balance
  override def withdraw(amount: Int): Boolean =
    if balance >= amount then
      balance -= amount
      true
    else false
  override def deposit(amount: Int): Boolean =
    balance += amount
    true

@main def accountsMain(): Unit =
  val johnsAccount: IAccount =
    new Account(100_000, "CLP")
