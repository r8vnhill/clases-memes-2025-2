package cl.uchile.dcc.munit

import scala.collection.mutable

class Money(val amount: Int, val currency: String):
  def add(other: Money): Money =
    new Money(amount + other.amount, currency)

  override def toString: String =
    s"Money($amount, $currency)"
  // ...
  override def equals(obj: Any): Boolean =
    if obj.isInstanceOf[Money] then
      val other = obj.asInstanceOf[Money]
      amount == other.amount && currency == other.currency
    else false

class MoneyBag:
  private val monies: mutable.Map[String, Money] =
    mutable.Map.empty

  def this(bag: Set[Money]) =
    this()
    for m <- bag do appendMoney(m)

  def this(m1: Money, m2: Money) =
    this(Set(m1, m2))

  def appendMoney(money: Money): Unit =
    val oMoney: Option[Money] = monies.get(money.currency)
    val newMoney: Money =
      if oMoney.isEmpty then money
      else oMoney.get.add(money)
    monies.update(money.currency, newMoney)

class MoneyTest extends munit.FunSuite:
  var _12clp: Money = null
  var _14clp: Money = null
  var _7usd: Money = null
  var _21usd: Money = null
  var _mb1: MoneyBag = null
  var _mb2: MoneyBag = null
  var o1: Option[Money] = None
  var o2: Option[Money] = Some(_12clp)

  // noinspection ScalaUnusedExpression
  override def beforeEach(context: BeforeEach): Unit =
    _12clp = new Money(12, "CLP")
    _14clp = new Money(14, "CLP")
    _7usd = new Money(7, "USD")
    _21usd = new Money(21, "USD")
    _mb1 = new MoneyBag(_12clp, _7usd)
    _mb2 = new MoneyBag(_14clp, _21usd)

  test("Equality of two Money objects with same amount and currency") {
    assertEquals(_12clp, _12clp)
    assertEquals(_12clp, new Money(12, "CLP"))
    assertEquals(new Money(12, "CLP"), _12clp)
    assertNotEquals(_12clp, _14clp)
  }

  test("Money can be added to another with the same currency") {
    val expected = new Money(26, "CLP")
    val result = _12clp.add(_14clp)
    assertEquals(expected, result)
  }

  test("MoneyBag equality") {
    assertEquals(_mb1, _mb1)
    assert(_mb1 != _12clp)
    assert(_12clp != _mb1)
    assertNotEquals(_mb1, _mb2)
  }
